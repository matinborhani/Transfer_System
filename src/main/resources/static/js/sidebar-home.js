function hide_SideBar() {
    var id_menu = "sidebar_menu";
    var menu = document.getElementById(id_menu);
    if (menu.style.display === "none")
        menu.style.display = "block"
    else
        menu.style.display = "none"
}