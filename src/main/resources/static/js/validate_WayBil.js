/*
create by matin borhani
in 1398/06/05
 */

function validate() {
    var resultWeight = checkWeight();
    if (resultWeight) {
        if (checkDateFormat()) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }
}

// check value of send date is before value of received date
function check_value_date(sendDate,receivedDate) {
    // because some time it call by another event with parameter sendDate,recivedDate
    if (sendDate == null){
        sendDate = document.getElementById("start_date").value;
        receivedDate = document.getElementById("finish_date").value;
    }
    var arrSend = sendDate.split("/");
    var arrReceived = receivedDate.split("/");
    debugger;
    for (var i = 0; i < arrSend.length; i++) {
        arrSend[i]=parseArabic(arrSend[i]);
        arrReceived[i]=parseArabic(arrReceived[i]);
    }
    if (arrSend[0] > arrReceived[0] ||
        arrSend[1] > arrReceived[1] ||
        arrSend[2] > arrReceived[2]){
        // scrollTop();
        // document.getElementById("date_periority_error").style.display="block";
        document.getElementById("hint_received_date").innerText = "تاریخ ارسال بعد از دریافت  وارد شده است";
        document.getElementById("start_date").classList.add("text-danger");
        document.getElementById("finish_date").classList.add("text-danger");
        return false;
    }
    else {
        // value of send date and received date are ok !
        document.getElementById("hint_received_date").innerText = "";
        document.getElementById("start_date").classList.add("text-success");
        document.getElementById("finish_date").classList.add("text-success");
        return true;
    }
}

// check national code driver
function check_National_Code() {
    var code = document.getElementById("national_Code_Driver").value;
    if (! cal_National_Code(code)){
        document.getElementById("national_Code_Driver").classList.add("text-danger");
        document.getElementById("hint_NTN_Driver").innerText="کد ملی صحیح نمی باشد"
    }
    else {
        document.getElementById("hint_NTN_Driver").innerText = "";
        document.getElementById("national_Code_Driver").classList.remove("text-danger");
        document.getElementById("national_Code_Driver").classList.add("text-success");

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
function check_tel() {
    var tel_Driver = document.getElementById("phone_Driver").value;
    debugger;
    // var arrMobile = getMobiles(tel_Driver);
    if (tel_Driver.length != 11 || isNaN(tel_Driver)){
        document.getElementById("phone_Driver").classList.add("text-danger");
        document.getElementById("hint_tel_Driver").innerText="شماره تلفن 11 عدد است"
    }
    else{
        document.getElementById("hint_tel_Driver").innerText = "";
        document.getElementById("phone_Driver").classList.remove("text-danger");
        document.getElementById("phone_Driver").classList.add("text-success");
    }


}


// check national code of sender company
function check_Cod_NTN_Sender() {

    var code = document.getElementById("national_Identify_Sender").value;
    if (! check_Shense_Meli(code)){
        document.getElementById("national_Identify_Sender").classList.add("text-danger");
        document.getElementById("hint_NTN_Sender").innerText="شناسه ملی فرستنده اشتباه است"
        // document.getElementById("cod_cod_ntn_error").style.display = "block";
        // scrollTop();
    }
    else{
        document.getElementById("hint_NTN_Sender").innerText = "";
        document.getElementById("national_Identify_Sender").classList.remove("text-danger");
        document.getElementById("national_Identify_Sender").classList.add("text-success");
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

// check tel sender . very similar to check_tel() !!
function check_tel_Sender() {
    var tel_Sender = document.getElementById("phone_Sender").value;
    debugger;
    // var arrMobile = getMobiles(tel_Driver);
    if (tel_Sender.length != 11 || isNaN(tel_Sender)){
        document.getElementById("phone_Sender").classList.add("text-danger");
        document.getElementById("hint_tel_Sender").innerHTML="شماره تلفن 11 عدد است";
    }
    else{
        document.getElementById("hint_tel_Sender").innerText = "";
        document.getElementById("phone_Sender").classList.remove("text-danger");
        document.getElementById("phone_Sender").classList.add("text-success");
    }


}

// check code post
function check_Sender_Cod_post() {
    var code = document.getElementById("post_Code_Sender").value;
    check_Cod_Post(code);
}
function check_Cod_Post(code) {
    debugger;
    if (code.length != 10 || isNaN(code)) {
        document.getElementById("post_Code_Sender").classList.add("text-danger");
        document.getElementById("hint_Code_Post_Sender").innerText = "کد پستی 10 عدد است"
    } else {
    document.getElementById("hint_Code_Post_Sender").innerText = "";
    document.getElementById("post_Code_Sender").classList.remove("text-danger");
    document.getElementById("post_Code_Sender").classList.add("text-success");
    }
}

// check national code of receiver company
function check_Cod_NTN_Receiver() {
    var code = document.getElementById("national_Identify_Receiver").value;
    if (! check_Shense_Meli(code)){
        document.getElementById("national_Identify_Receiver").classList.add("text-danger");
        document.getElementById("hint_NTN_Receiver").innerText="شناسه ملی گیرنده اشتباه است"
    }
    else{
        document.getElementById("hint_NTN_Receiver").innerText = "";
        document.getElementById("national_Identify_Receiver").classList.remove("text-danger");
        document.getElementById("national_Identify_Receiver").classList.add("text-success");
    }
}

// check tel of receiver
function check_tel_Receiver() {
    var tel_Receiver = document.getElementById("phone_Receiver").value;
    debugger;
    // var arrMobile = getMobiles(tel_Driver);
    if (tel_Receiver.length != 11 || isNaN(tel_Receiver)){
        document.getElementById("phone_Receiver").classList.add("text-danger");
        document.getElementById("hint_tel_Receiver").innerHTML="شماره تلفن 11 عدد است";
    }
    else{
        document.getElementById("hint_tel_Receiver").innerText = "";
        document.getElementById("phone_Receiver").classList.remove("text-danger");
        document.getElementById("phone_Receiver").classList.add("text-success");
    }


}

 // check code post of receiver
function check_Receiver_Cod_Post() {
    var code = document.getElementById("post_Code_Receiver").value;
    check_Cod_Post_Receiver(code);
}
function check_Cod_Post_Receiver(code) {
    debugger;
    if (code.length != 10 || isNaN(code)) {
        document.getElementById("post_Code_Receiver").classList.add("text-danger");
        document.getElementById("hint_Code_Post_Receiver").innerText = "کد پستی 10 عدد است"
    } else {
        document.getElementById("hint_Code_Post_Receiver").innerText = "";
        document.getElementById("post_Code_Receiver").classList.remove("text-danger");
        document.getElementById("post_Code_Receiver").classList.add("text-success");
    }
}


function checkWeight() {
    var weightValue = document.forms["form"]["weight"].value;

    if (isNaN(weightValue)|| weightValue == "" || weightValue <0) {
        scrollTop();
        document.getElementById("weight_error").style.display = "block";
        return false;
    }
    else{
        return true;
    }
}

function checkDateFormat() {
    // var sendDate = document.forms["form"]["sendDate"];
    var sendDate = document.getElementById("start_date").value;
    var partOneSend = sendDate.charAt(4);
    var partTwoSend = sendDate.charAt(7);
    if (partOneSend != "/" || partTwoSend != "/"){
        document.getElementById("hint_start_date").innerHTML = "فرمت تاریخ ارسال را به درستی وارد کنید";
        document.getElementById("start_date").classList.add("text-danger");
        // document.getElementById("date_send_error").style.display="block";
        return false;
    }
    // for reciver
    // var receivedDate = document.forms["form"]["receivedDate"].value;
    var receivedDate = document.getElementById("finish_date").value;
    var partOneReceiver = receivedDate.charAt(4);
    var partTwoReceiver = receivedDate.charAt(7);
    if (partOneReceiver != "/" || partTwoReceiver != "/"){
        document.getElementById("hint_received_date").innerHTML = "فرمت تاریخ ارسال را به درستی وارد کنید";
        document.getElementById("finish_date").classList.add("text-danger");
        // document.getElementById("date_rec_error").style.display="block";
        return false;
    }
    if (!check_value_date(sendDate,receivedDate))
        return false;
    // if all thing ok
    document.getElementById("start_date").classList.add("text-success");
    document.getElementById("finish_date").classList.add("text-success");
    document.getElementById("hint_start_date").innerHTML = "";
    document.getElementById("hint_received_date").innerHTML = "";
    return true
}

function parseArabic(str) {
    return Number( str.replace(/[٠١٢٣٤٥٦٧٨٩]/g, function(d) {
        return d.charCodeAt(0) - 1632; // Convert Arabic numbers
    }).replace(/[۰۱۲۳۴۵۶۷۸۹]/g, function(d) {
        return d.charCodeAt(0) - 1776; // Convert Persian numbers
    }) );
}
