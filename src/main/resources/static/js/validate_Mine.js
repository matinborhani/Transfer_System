/*
create by matin borhani
in 1398/06/25
 */


function validate_NTN_Code_Mine() {
    var ntn_code = document.getElementById("national_code").value;
    var result = check_Shense_Meli(ntn_code);
    if (!result) {
        document.getElementById("national_code").classList.add("text-danger");
        document.getElementById("hint_NTN_Mine").innerText="شناسه ملی صحیح نمی باشد"
    }
    else {
        document.getElementById("hint_NTN_Mine").innerText = "";
        document.getElementById("national_code").classList.remove("text-danger");
        document.getElementById("national_code").classList.add("text-success");

    }
}

// valid function from external
function check_Shense_Meli(code){

    var L=code.length;

    if(L<11 || parseInt(code,10)==0) return false;

    if(parseInt(code.substr(3,6),10)==0) return false;
    var c=parseInt(code.substr(10,1),10);
    var d=parseInt(code.substr(9,1),10)+2;
    var z=new Array(29,27,23,19,17);
    var s=0;
    for(var i=0;i<10;i++)
        s+=(d+parseInt(code.substr(i,1),10))*z[i%5];
    s=s%11;if(s==10) s=0;
    return (c==s);

}


// valid code post
function validate_Code_Post() {
    var code = document.getElementById("post_code").value;
    if (code.length != 10 || isNaN(code)) {
        document.getElementById("post_code").classList.add("text-danger");
        document.getElementById("hint_Code_Post").innerText = "کد پستی 10 عدد است"
    } else {
        document.getElementById("hint_Code_Post").innerText = "";
        document.getElementById("post_Code").classList.remove("text-danger");
        document.getElementById("post_Code").classList.add("text-success");
    }
}

function validate_Tel_Mine() {
    var tel_Sender = document.getElementById("tel_mine").value;
    debugger;
    // var arrMobile = getMobiles(tel_Driver);
    if (tel_Sender.length != 11 || isNaN(tel_Sender)){
        document.getElementById("tel_mine").classList.add("text-danger");
        document.getElementById("hint_tel_Mine").innerHTML="شماره تلفن 11 عدد است";
    }
    else{
        document.getElementById("hint_tel_Mine").innerText = "";
        document.getElementById("tel_mine").classList.remove("text-danger");
        document.getElementById("tel_mine").classList.add("text-success");
    }
}