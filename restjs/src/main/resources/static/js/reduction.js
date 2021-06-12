function todoReduction(){
    var numerator = document.getElementById('num').value;
    var denominator = document.getElementById('denum').value;

    $.ajax({
        //url: "/emailsend?" + $.param(EmailData),
        url: '/rest/reduction',
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
            document.getElementById('titleReduction').innerHTML = 'Результат сокращения';
            document.getElementById('rezreduction1').innerHTML = data["num"];
            document.getElementById('rezreduction2').innerHTML = data['denum'];
            //
            document.getElementById('rezcheck').innerHTML = "";
        },
        error: function (data, status, er) {

        }

    });



}