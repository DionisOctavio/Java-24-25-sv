import { PeliculaService } from "../js/service/peliculaService.js";
import { ComentarioService } from "../js/service/comentarioService.js";
import { CategoriaService } from "../js/service/categoriaService.js";

let peliculas = [];
let categorias = [];

async function cargarCategorias() {
  categorias = await CategoriaService.findAll();

  const container = document.getElementById("categoria-buttons");
  container.innerHTML = "";

  // Botón "Todas"
  const btnTodas = document.createElement("button");
  btnTodas.textContent = "Todas";
  btnTodas.value = "";
  btnTodas.onclick = async () => {
    peliculas = await PeliculaService.findAll();
    pintarPeliculas(peliculas);
    cargarSelectPeliculas(peliculas);
  };
  container.appendChild(btnTodas);

  // Botones por categoría
  categorias.forEach(c => {
    const btn = document.createElement("button");
    btn.textContent = c.nombre;
    btn.value = c.id_categoria;
    btn.style.marginLeft = "0.5em";

    btn.onclick = async () => {
      peliculas = await PeliculaService.findByCategory(c.id_categoria);
      pintarPeliculas(peliculas);
      cargarSelectPeliculas(peliculas);
    };

    container.appendChild(btn);
  });
}

function pintarPeliculas(peliculas) {
  const ul = document.getElementById("peliculas-list");
  ul.innerHTML = "";

  if (peliculas.length === 0) {
    ul.innerHTML = "<li>No hay películas en esta categoría.</li>";
    return;
  }

  peliculas.forEach(p => {
    const li = document.createElement("li");
    li.textContent = `${p.titulo} (${p.anio})`;
    ul.appendChild(li);
  });
}

function cargarSelectPeliculas(peliculas) {
  const select = document.getElementById("pelicula-select");
  select.innerHTML = '<option value="">-- Selecciona una película --</option>';

  peliculas.forEach(p => {
    const option = document.createElement("option");
    option.value = p.id_pelicula;
    option.textContent = p.titulo;
    select.appendChild(option);
  });
}

async function enviarComentario() {
  const texto = document.getElementById("comentario-text").value.trim();
  const id_pelicula = document.getElementById("pelicula-select").value;
  const usuario = JSON.parse(localStorage.getItem('usuario')) || {};
  const id_usuario = usuario.id_username || 0;

  if (!texto || !id_pelicula || !id_usuario) {
    alert("Faltan datos: comentario, película o usuario.");
    return;
  }

  const comentario = { texto, id_usuario, id_pelicula };
  try {
    const result = await ComentarioService.add(comentario);
    alert(result.msg);
    document.getElementById("comentario-text").value = "";
  } catch {
    alert("Error al enviar comentario");
  }
}

async function agregarPelicula() {
  const titulo = document.getElementById("titulo-input").value.trim();
  const anio = parseInt(document.getElementById("anio-input").value);
  const id_categoria = parseInt(document.getElementById("categoria-select").value);

  if (!titulo || isNaN(anio) || isNaN(id_categoria)) {
    alert("Todos los campos son obligatorios.");
    return;
  }

  const pelicula = { titulo, anio, id_categoria };

  try {
    const result = await PeliculaService.add(pelicula);
    alert(result.message || "Película agregada.");

    // Recargar lista tras agregar
    peliculas = await PeliculaService.findAll();
    pintarPeliculas(peliculas);
    cargarSelectPeliculas(peliculas);

    // Limpiar inputs
    document.getElementById("titulo-input").value = "";
    document.getElementById("anio-input").value = "";
    document.getElementById("categoria-select").value = "";
  } catch {
    alert("Error al agregar la película.");
  }
}

async function buscarPorTitulo() {
  const titulo = document.getElementById("buscar-titulo-input").value.trim();
  if (!titulo) {
    alert("Introduce un título para buscar.");
    return;
  }

  try {
    peliculas = await PeliculaService.findByTitle(titulo);
    pintarPeliculas(peliculas);
    cargarSelectPeliculas(peliculas);
  } catch {
    alert("Error al buscar películas.");
  }
}


window.onload = async () => {
  await cargarCategorias();

  const selectCategoria = document.getElementById("categoria-select");
  categorias.forEach(c => {
    const option = document.createElement("option");
    option.value = c.id_categoria;
    option.textContent = c.nombre;
    selectCategoria.appendChild(option);
  });

  peliculas = await PeliculaService.findAll();
  pintarPeliculas(peliculas);
  cargarSelectPeliculas(peliculas);

  document.getElementById("btn-comentar").onclick = (e) => {
    e.preventDefault();
    enviarComentario();
  };

  document.getElementById("btn-agregar-pelicula").onclick = (e) => {
    e.preventDefault();
    agregarPelicula();
  };

  document.getElementById("btn-buscar-titulo").onclick = (e) => {
    e.preventDefault();
    buscarPorTitulo();
  };
};

