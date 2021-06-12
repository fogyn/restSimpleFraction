function todo(){
    var numerator = document.getElementById('num').value;
    var denominator = document.getElementById('denum').value;

    var rad=document.getElementsByName('act');
    var type;
    for (var i=0;i<rad.length; i++) {
        if (rad[i].checked) {
            type = rad[i].value;
            alert(type);
            break;
        }
    }
    type = Number(type);
    // if(type==0){
    //     alert('ура')
    // }
    // if(type==1){
    //     alert('ура222')
    // }


    switch (type) {
        case 0:
            $.ajax({
                url: '/rest/check',
                type: 'GET',
                cache: false,
                //data: "testD=" + "пришел", "testM": mas,
                data: "testD="+numerator+"&testM="+denominator,
                success: function (data) {
                    document.getElementById('titleRez').innerHTML = "Проверка правильности дроби";
                    document.getElementById('rez1').innerHTML =data;

                },
                error: function (data, status, er) {
                }

            });
            break;
        case 1:
            $.ajax({
                url: '/rest/reduction',
                type: 'GET',
                cache: false,
                data: "testD="+numerator+"&testM="+denominator,
                success: function (data) {

                    document.getElementById('titleRez').innerHTML = data['type'];
                    document.getElementById('rez1').innerHTML = data['num'];
                    document.getElementById('rez2').innerHTML = data['denum'];

                },
                error: function (data, status, er) {
                }

            });
            break;

        // default:
        //     alert( "Нет таких значений" );
    }

    document.getElementById("num").value = "";
    document.getElementById("denum").value = "";
}