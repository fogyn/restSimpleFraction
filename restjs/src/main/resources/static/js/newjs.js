function makePost(){
    var data = ""; // if you want to pass data as request param then assign here
    var name = "пробуем";
    alert(name);

    //var namejs = JSON.stringify(name);
    $.ajax({

        url: 'testpost',
        type: 'POST',
        cache: false,
        data: "name=" + name,
        //data: mas,

        success: function (data) {

            //del2 = data.delete;
            //$('#idrez').append(data);
            alert(data);
            document.getElementById("idrez").innerHTML = data;
        },
        error: function (data, status, er) {

        }

    });
}