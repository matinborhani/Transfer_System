function check_National_Code() {
    var code = document.getElementById("national_Code_Driver").value;
    if (! cal_National_Code(code)){
        document.getElementById("cod_ntn_error").style.display="block"
    }
    else
        document.getElementById("cod_ntn_error").style.display = "none";
}

function cal_National_Code(code)
{

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

function check_tel_Driver() {
    var tel_Driver = document.getElementById("phone_Driver").value;
    debugger;
    // var arrMobile = getMobiles(tel_Driver);
    if (tel_Driver.length != 11 || isNaN(tel_Driver)){
        scrollTop();
        document.getElementById("tel_driver_error").style.display = "block";
    }
    else
        document.getElementById("tel_driver_error").style.display = "none";

}

function check_Cod_NTN_Sender() {

    var code = document.getElementById("national_Identify_Sender").value;
    if (! check_Shense_Meli(code)){
        document.getElementById("cod_cod_ntn_error").style.display = "block";
        show_Element(document.getElementById("national_Identify_Sender_Block"))
        scrollTop();
    }
    else{
        // all things good
        document.getElementById("cod_cod_ntn_error").style.display = "none";
        hide_Element(document.getElementById("national_Identify_Sender_Block"))
    }
}

function check_Cod_NTN_Reciever() {
    debugger;
    var code = document.getElementById("national_Identify_Receiver").value;
    if (! check_Shense_Meli(code)){
        scrollTop();
        document.getElementById("cod_cod_ntn_error").style.display = "block";

    }
    else
        document.getElementById("cod_cod_ntn_error").style.display = "none";
}

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

function check_Sender_Cod_post() {
    var code = document.getElementById("post_Code_Sender").value;
    check_Cod_Post(code);
}

function check_Reciever_Cod_Post() {
    var code = document.getElementById("post_Code_Receiver").value;
    check_Cod_Post(code);
}

function check_Cod_Post(code) {
    debugger;
    if (code.length != 10 ||  isNaN(code)){
        scrollTop();
        document.getElementById("cod_post_error").style.display="block";
    }
    else
        document.getElementById("cod_post_error").style.display="none";
}

function hide_Element(element){
    element.style.display="none";
}

function show_Element(element) {
    element.style.display="block";
}
