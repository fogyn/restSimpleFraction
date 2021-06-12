function todocheck(){
    var numerator = document.getElementById('num').value;
    var denominator = document.getElementById('denum').value;
    //document.getElementById('rezcheck').innerHTML = 'проверка';

    // mas = [];
    // mas.push(numerator);
    // mas.push(denominator);
    //
    // console.log(mas[0]);
    // console.log(mas[1]);
//JSON.stringify(EmailData)
//     var EmailData = {
//         "covere" : "John",
//         "title" :"Boston",
//         "username" :"test@yahoo.fr",
//         "usernameto" :"test@yahoo.fr"
//     };
//
//     var d = {
//         "num": numerator,
//         "denum":denominator
//     };
//     d = JSON.stringify(d);
    $.ajax({
        //url: "/emailsend?" + $.param(EmailData),
        url: '/rest/check',
        type: 'GET',
        cache: false,
        //data: "testD=" + "пришел", "testM": mas,
        data: "testD="+numerator+"&testM="+denominator,
        //data: d,

        success: function (data) {

            //del2 = data.delete;
            //$('#idrez').append(data);
            alert(data);
            //location.reload();
            document.getElementById('rezcheck').innerHTML = data;
            //
            document.getElementById('titleReduction').innerHTML = "";
            document.getElementById('rezreduction1').innerHTML ="";
            document.getElementById('rezreduction2').innerHTML = "";
        },
        error: function (data, status, er) {

        }

    });
}