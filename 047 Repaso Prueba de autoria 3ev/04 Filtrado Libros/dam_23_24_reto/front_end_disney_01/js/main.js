import { LibroService } from "./api/libroService.js";
import { GeneroService } from "./api/generoService.js";

const $generos = document.getElementById("generos");
const $libros = document.getElementById("libros");

window.addEventListener("load", async () => {
  renderLibros(await LibroService.find());
  renderGeneros(await GeneroService.find());
});

const renderLibros = (libros) => {
  $libros.innerHTML = libros.map(l => `<div class="libro"><h3>${l.nombre}</h3></div>`).join("");
};

const renderGeneros = (generos) => {
  $generos.innerHTML = "";
  const crearBoton = (texto, handler) => {
    const btn = document.createElement("button");
    btn.textContent = texto;
    btn.onclick = handler;
    $generos.appendChild(btn);
  };

  crearBoton("Todos", async () => renderLibros(await LibroService.find()));
  
  generos.forEach(g =>
    crearBoton(g.nombre, async () => renderLibros(await LibroService.findByGenero(g.nombre)))
  );
};
