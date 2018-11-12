

    function onlyOneCheckBox() {
        var checkboxgroup = document.getElementById('checkboxgroup').getElementsByTagName("input");
        var limit = 4;
        for (var i = 0; i < checkboxgroup.length; i++) {
            checkboxgroup[i].onclick = function() {
                var checkedcount = 0;
                for (var i = 0; i < checkboxgroup.length; i++) {
                    checkedcount += (checkboxgroup[i].checked) ? 1 : 0;
                }
                if (checkedcount > limit) {
                    alert("Selection de maximum " + limit + " ingredients, gros lard.");
                    this.checked = false;
                }
            }
        }
    }
