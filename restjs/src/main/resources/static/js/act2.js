function todo2(){
    var numerator1 = document.getElementById('num1').value;
    var denominator1 = document.getElementById('denum1').value;

    var numerator2 = document.getElementById('num2').value;
    var denominator2= document.getElementById('denum2').value;

    var rad=document.getElementsByName('act2');
    var type='';
    for (var i=0;i<rad.length; i++) {
        if (rad[i].checked) {
            type = rad[i].value;
            alert(type);
            break;
        }
    }
    type = Number(type);

    switch (type) {
        case 2:
            $.ajax({
                url: '/rest/sum',
                type: 'GET',
                cache: false,

                data: "num1="+numerator1+"&denum1="+denominator1+"&num2="+numerator2+"&denum2="+denominator2,
                success: function (data) {
                    document.getElementById('titleRez').innerHTML = data['type'];
                    document.getElementById('rez1').innerHTML = data['num'];
                    document.getElementById('rez2').innerHTML = data['denum'];

                },
                error: function (data, status, er) {
                }

            });
            break;
        case 3:
            $.ajax({
                url: '/rest/sub',
                type: 'GET',
                cache: false,
                data: "num1="+numerator1+"&denum1="+denominator1+"&num2="+numerator2+"&denum2="+denominator2,
                success: function (data) {

                    document.getElementById('titleRez').innerHTML = data['type'];
                    document.getElementById('rez1').innerHTML = data['num'];
                    document.getElementById('rez2').innerHTML = data['denum'];

                },
                error: function (data, status, er) {
                }

            });
            break;
        case 4:
            $.ajax({
                url: '/rest/multiple',
                type: 'GET',
                cache: false,
                data: "num1="+numerator1+"&denum1="+denominator1+"&num2="+numerator2+"&denum2="+denominator2,
                success: function (data) {

                    document.getElementById('titleRez').innerHTML = data['type'];
                    document.getElementById('rez1').innerHTML = data['num'];
                    document.getElementById('rez2').innerHTML = data['denum'];

                },
                error: function (data, status, er) {
                }

            });
            break;
        case 5:
            $.ajax({
                url: '/rest/div',
                type: 'GET',
                cache: false,
                data: "num1="+numerator1+"&denum1="+denominator1+"&num2="+numerator2+"&denum2="+denominator2,
                success: function (data) {

                    document.getElementById('titleRez').innerHTML = data['type'];
                    document.getElementById('rez1').innerHTML = data['num'];
                    document.getElementById('rez2').innerHTML = data['denum'];

                },
                error: function (data, status, er) {
                }

            });
            break;
    }
    document.getElementById("num1").value = "";
    document.getElementById("denum1").value = "";
    document.getElementById("num2").value = "";
    document.getElementById("denum2").value = "";

    // document.getElementById('titleRez').innerHTML = type;
    // document.getElementById('rez1').innerHTML = numerator1+' : '+numerator2;
    // document.getElementById('rez2').innerHTML = denominator1+' : '+denominator2;



}