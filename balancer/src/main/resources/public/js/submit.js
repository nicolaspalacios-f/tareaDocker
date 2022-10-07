function postcadena() {
    var cadena = document.getElementById("cadena").value;
    document.getElementById("cadena").value = "";
    console.log("fa")
    var url = "/balancer?value=" + cadena;
    fetch(url,{
        method: 'POST',
        mode: 'cors', 
        cache: 'no-cache',
        credentials: 'same-origin',
      }).then(res=>res.json()).then(function (data) {
        console.log(data);
        var tbl = document.getElementById("tabla");
        var rowCount = tbl.rows.length;
        for (var x = rowCount - 1; x > 0; x--) {
            tbl.deleteRow(x);
        }
        data.forEach(element => {
            let row = tbl.insertRow();
            let fecha = row.insertCell();
            let cadena = row.insertCell();
            fecha.innerHTML = element.fecha;
            cadena.innerHTML = element.value;
        });
    });
}