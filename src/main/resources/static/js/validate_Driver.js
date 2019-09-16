/*
create by matin borhani
in 1398/06/18
 */



function validate_NTN_Code() {
    var value = document.getElementById("national_code").value;
    var result = cal_National_Code(value);
    if (!result){
        document.getElementById("national_code").classList.add("text-danger");
        document.getElementById("hint_NTN_Driver").innerText="کد ملی صحیح نمی باشد"
    }
    else {
        document.getElementById("hint_NTN_Driver").innerText = "";
        document.getElementById("national_code").classList.remove("text-danger");
        document.getElementById("national_code").classList.add("text-success");

    }
}

// check national code is true of not
function cal_National_Code(code){

    var L=code.length;

    if(L<8 || parseInt(code,10)==0) return false;
    code=('0000'+code).substr(L+4-10);
    if(parseInt(code.substr(3,6),10)==0) return false;
    var c=parseInt(code.substr(9,1),10);
    var s=0;
    for(var i=0;i<9;i++)
        s+=parseInt(code.substr(i,1),10)*(10-i);
    s=s%11;
    return (s<2 && c==s) || (s>=2 && c==(11-s));
    return true;
}

// check tel driver
function validate_tel() {
    var tel_Driver = document.getElementById("tel_drv").value;
    debugger;
    // var arrMobile = getMobiles(tel_Driver);
    if (tel_Driver.length != 11 || isNaN(tel_Driver)) {
        document.getElementById("tel_drv").classList.add("text-danger");
        document.getElementById("hint_tel_Driver").innerText = "شماره تلفن 11 عدد است";
    } else {
        document.getElementById("hint_tel_Driver").innerText = "";
        document.getElementById("tel_drv").classList.remove("text-danger");
        document.getElementById("tel_drv").classList.add("text-success");
    }
}

function validate_Lics_Drv() {
    var lics_driving = document.getElementById("lics_drv").value;
    if (lics_driving.length != 11){
        document.getElementById("lics_drv").classList.add("text-danger");
        document.getElementById("hint_Lics_Driver").innerText = "شماره گواهینامه 10 عدد است";
    }
    else {
        document.getElementById("hint_Lics_Driver").innerText = "";
        document.getElementById("lics_drv").classList.remove("text-danger");
        document.getElementById("lics_drv").classList.add("text-success");
    }
}
