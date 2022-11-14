document.addEventListener("DOMContentLoaded", () => {
  let table = document.getElementById("tableData");

  async function getActiveClientes() {
    //const clientes = await axios("http://localhost:8080/cliente/query?estado=true")
    const clientes = await axios({
      method: "GET",
      url: "http://localhost:8080/cliente",
      withCredentials: false,
      mode: "no-cors",
      headers: {
        "Content-Type": "application/json",
      },
    });

    clientes.data.forEach((element) => {
      console.log(element);
      // fill table
      table.innerHTML += `
        <tr id="${element.id}">
            <td>${element.nombre}</td>
            <td>${element.apellido}</td>
            <td>${element.localidad}</td>
            <td>${element.direccion}</td>
            <td>${element.dni}</td>
        </tr>`;
    });
  }

  getActiveClientes();
});

async function deleteCliente(id) {
  const clientes = await axios({
    method: "DELETE",
    url: `http://localhost:8080/cliente/${id}`,
    withCredentials: false,
    mode: "no-cors",
    headers: {
      "Content-Type": "application/json",
    },
  });

  
}
