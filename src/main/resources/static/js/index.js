document.addEventListener("DOMContentLoaded", () => {
    console.log("a")

    async function getActiveClientes() {
        const clientes = await axios("http://localhost:8080/cliente/query?estado=true")
        return await clientes
    }

    async function loadData(){
        return await getActiveClientes()
    }

    //loadData().then(data => console.log(data.data))
    function insertToTable(data){
        let table = document.getElementById("clientesTable")
        table.append()
    }
})