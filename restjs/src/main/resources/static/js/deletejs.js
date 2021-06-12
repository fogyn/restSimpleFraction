function clickTest(){
    var name = "пробуем удалить";
    alert(name);
    $.ajax({

        url: '/rest/test',
        type: 'GET',
        cache: false,
        data: "testD=" + name,
        //data: mas,

        success: function (data) {

            //del2 = data.delete;
            //$('#idrez').append(data);
            alert(data);
            document.getElementById("rezServer").innerHTML = data;
        },
        error: function (data, status, er) {

        }

    });
    // console.log("Тест");
    // var response = fetch("/test");
    //
    // var t = response.parseJSON;
    // alert(t);
    // document.getElementById("rez").innerHTML = "Тест";
    // document.getElementById("rezServer").innerHTML = text["id"];
    // alert(t["text"]);
}

// function makeDeleteSomeCity(){
//     var data = ""; // if you want to pass data as request param then assign here
//     var mas = [];
//     $('input[name=chcity]').each(function(){
//         if($(this).prop('checked')){
//             mas.push($(this).val());
//         }
//     });
//
//     var json1 = JSON.stringify(mas);
//     $.ajax({
//
//         url: 'deleteSomeCity',
//         type: 'POST',
//         cache: false,
//         data: "term=" + mas,
//         //data: mas,
//
//         success: function (data) {
//
//             del2 = data.delete;
//             $('#delСountryCityajax').append(data.delete);
//         },
//         error: function (data, status, er) {
//
//         }
//
//     });
// }