import { EquipoService } from "./api/equipoService.js";
import { CategoriaService } from "./api/categoriaService.js";

const contenedor = document.getElementById("resultado-equipos");
const selectCategoria = document.getElementById("select-categoria");
const inputBuscar = document.getElementById("input-buscar");
const botonBuscar = document.getElementById("btn-buscar");


window.addEventListener("load", async () => {
  console.log("Cargando categorías...");
  const categorias = await CategoriaService.listarCategorias();
  console.log("Categorías recibidas:", categorias);

  selectCategoria.innerHTML = categorias.map(c =>
      `<option value="${c.nombre_categoria}">${c.nombre_categoria}</option>`
  ).join("");

  console.log("Cargando todos los equipos...");
  const equipos = await EquipoService.listarEquipos();
  console.log("Equipos recibidos:", equipos);

  renderEquipos(equipos);
});


botonBuscar.addEventListener("click", async () => {
  const nombre = inputBuscar.value.trim();
  const categoria = selectCategoria.value;

  console.log("Buscando con:", { categoria, nombre });

  const equipos = await EquipoService.searchAndCategory(categoria, nombre);

  console.log("Equipos encontrados:", equipos);

  renderEquipos(equipos);
});


function renderEquipos(lista) {
  contenedor.innerHTML = "";

  if (!lista || lista.length === 0) {
    contenedor.innerHTML = "<p>No se encontraron equipos.</p>";
    return;
  }

  lista.forEach(eq => {
    const div = document.createElement("div");
    div.innerHTML = `<h3>${eq.nombre_equipo}</h3>`;
    contenedor.appendChild(div);
  });
}
