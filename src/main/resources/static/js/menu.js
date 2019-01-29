$(function () {

     function openMenu(menu) {
         var parentUl = menu.parent();
         var parentLi = parentUl.parent();
         if (parentUl.hasClass("treeview-menu") && parentLi.hasClass("treeview")) {
             parentUl.css("display", "block");
             parentLi.addClass("menu-open");
         }
         var p_parentUl = parentLi.parent();
         var p_parentLi = p_parentUl.parent();

         if (p_parentUl.hasClass("treeview-menu") && p_parentLi.hasClass("treeview")) {
             openMenu(parentLi);
         }
    }

    var url = window.document.location.pathname;

    var menu = $("[href$='" + url + "']");

    if (menu) {
        menu = menu.parent();
    }

    menu.addClass("active");
    openMenu(menu);

});