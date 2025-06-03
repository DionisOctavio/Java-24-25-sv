export class HackatonComponent {
    constructor(hack) {
        this.hack = hack;
    }
    render() {
        const hackatonElement = document.createElement('div');
        hackatonElement.classList.add('hack');
        hackatonElement.innerHTML = `
          <div class="hackaton-card">
            <h2>${this.hack.nombre}</h2> 
            <p class="descripcion"><em>${this.hack.descripcion}</em></p>
            <p class="categoria">Categoría: <strong>${this.hack.categoria.nombre}</strong></p>
          </div>
        `;

        return hackatonElement;
    }
}