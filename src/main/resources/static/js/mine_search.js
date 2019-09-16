function clickByName() {
    var byName=document.getElementById("byName");
    var byId=document.getElementById("byId");
    if (byId.checked == true) {
        byId.checked = false;
        document.getElementById("search_By_NTN").style.display="none";
        document.getElementById("search_By_Name").style.display="block";
    }
}

function clickByNational() {
    var byName=document.getElementById("byName");
    var byId=document.getElementById("byId");
    if (byName.checked == true) {
        byName.checked = false;
        document.getElementById("search_By_Name").style.display="none";
        document.getElementById("search_By_NTN").style.display="block";
    }
}