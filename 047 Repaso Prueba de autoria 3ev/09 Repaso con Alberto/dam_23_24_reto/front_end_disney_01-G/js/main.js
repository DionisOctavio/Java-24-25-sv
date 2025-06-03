import { HackatonService } from './api/hackatonService.js';
import { HackatonComponent } from './components/hackatonComponents.js';

const appContainer = document.getElementById("app");
const selectContainer = document.getElementById("categoria");
const searchContainer = document.getElementById("nombre");

async function pintar(){

  const category = selectContainer.value; // DATO NUEVO
  const search = searchContainer.value; // DATO NUEVO

  appContainer.innerHTML = ""; // DATO NUEVO

  const Hack = await HackatonService.listarHackatones(category, search);
  console.log("HACKATONES: ", Hack);

  Hack.forEach(
      hack => {
        console.log("ID: ", hack.id);
        console.log("NOMBRE: ", hack.nombre);

        const hackComp = new HackatonComponent(hack);
        const hackHTML = hackComp.render();
        appContainer.appendChild(hackHTML);
    }
  );
}


window.addEventListener("load", pintar);
selectContainer.addEventListener("change", pintar); // DATO NUEVO
searchContainer.addEventListener("input", pintar); // DATO NUEVO