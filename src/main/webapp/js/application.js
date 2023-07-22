
$(document).ready(function(){
    $('input').last().on('click',function(){
        if ($("input[name=format]").prop( "checked")===true){
            $("form").submit();
        }
        else{
            $.ajax({
                url: "rest/somme-et-produit",
                data: $("form").serialize(),
                success: function(resultObject) {
                    $("p").remove();
                    var message = "<p>Le somme des 2 nombres est de "+ resultObject.somme.numerique+ " - " + resultObject.somme.texte+"</p>"
                    message = message.concat("<p>Le produit des 2 nombres est de "+ resultObject.produit.numerique+ " - " + resultObject.produit.texte+"</p>")
                    $("form").after(message);
                }
            });
        }
    });
});

$(document).ready(function () {
    $('#catalogue').on("click", function () {
        $.ajax({
            url: 'rest/catalogue/liste',
            success: function (data) {
                $('#catalog').empty();
                data.forEach(w => {
                    $('#catalog').append("<li><b>" + w.mainArtist.name + "</b> - " + w.title + " (" + w.release + ")</li>");
                });
            }
        });
    });
});

$(document).ready(function () {
    $('a[href=catalogue]').on('click', function (event) {
        event.preventDefault();
        if ($('body').children().length<6) {
            $.ajax({
                url: "rest/work",

                success: function (result) {
                    var catalog='';
                    result.forEach(function(nextWork){
                        catalog=catalog.concat(nextWork.title+" ("+nextWork.release+")<BR/>");
                    });

                    $("a[href=catalogue]").after('<br>'+catalog);
                }
            });
        }
    });
});
//
// $(document).ready(function () {
//     $('a[href=catalogue]').on('click', function (event) {
//         event.preventDefault();
//
//         if ($('body').children().length<6) {
//             $.ajax({
//                 url: "catalogue",
//                 success: function (result) {
//                     var catalog='';
//                     result.forEach(function(nextWork){
//                         catalog=catalog.concat(nextWork.title+" ("+nextWork.release+")<BR/>");
//                     });
//
//                     $("a[href=catalogue]").after('<br>'+catalog);
//                 }
//             });
//         }
//     });
// });