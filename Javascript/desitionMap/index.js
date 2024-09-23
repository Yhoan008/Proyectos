const question = document.getElementById("question");
const help = document.getElementById("help");
const back = document.getElementById("back");
const helpBar = document.getElementById("helpBar");
const options = document.getElementById("options");
const clock = document.getElementById("clock");
const clockBar = document.getElementById("clockBar");
const menu = document.getElementById("menu");
const menuBar = document.getElementById("menuBar");
const reiniciar = document.getElementById("reiniciar");
const reportError = document.getElementById("reportError");

let base;

async function getData() {
  base = await fetch("./base.json").
    then(data => data.json()).
    catch(error => { console.log(error) });

  return base
}

getData().then(data => {

  let history = [];
  let instance = data;

  function changeIntance(id) {
    instance = instance.product[id];
    history = [...history, instance]
    draw(instance, history, changeIntance, backInstance)
  }

  function backInstance(id) {
    history = history.slice(0, id + 1)
    instance = history[history.length - 1]
    draw(instance, history, changeIntance, backInstance);
  }

  history = [data]
  draw(data, history, changeIntance, backInstance)


  back.addEventListener("click", () => {
    if (history.length <= 1) {
      console.log("retorno invalido")
    } else {
      history = history.slice(0, -1)
      instance = history[history.length - 1]
      draw(instance, history, changeIntance, backInstance)
    }
  })

  reiniciar.addEventListener("click", () => {
    instance = data;
    history = [data];
    draw(instance, history, changeIntance, backInstance)
  })


})

function draw(data, history, changeIntance, backInstance) {
  if (data === undefined) { console.error("la instancia es invalida") }
  if (data.help !== undefined) {
    help.style.display = "block";
    helpBar.innerText = `${data.help}`
  } else {
    help.style.display = "none";
  }
  question.innerText = `${data.question}`;

  clockBar.innerHTML = "";

  const title = document.createElement('h1');
  title.textContent = "Historial";
  title.classList = ('text-xl font-bold  p-2 border-y-2 border-black ');
  clockBar.appendChild(title); // Añadir el título al contenedor

  history.forEach((index, id) => {
    const paragraph = document.createElement('p');
    paragraph.textContent = index.descrip;
    paragraph.classList = 'text-gray-800 block font-bold h-full py-2 pl-2 hover:bg-gray-300';
    paragraph.addEventListener("click", () => {
      backInstance(id);
    })
    clockBar.appendChild(paragraph);
  })
  if (data.type == "multitask") {

    const contain = document.createElement("select");
    const defa = document.createElement("option");

    options.innerHTML = "";

    contain.classList = "py-2 px-5 max-w-[400px] mt-5 rounded font-bold text-xl bg-[#011059] text-white";
    defa.innerText = "Selecciona una opción:"
    contain.appendChild(defa);
    data.options.forEach(element => {
      const option = document.createElement("option");
      option.innerText = element;
      contain.appendChild(option);
    });

    contain.addEventListener("change", () => {
      if (contain.selectedIndex > 0) {
        changeIntance(contain.selectedIndex - 1)
      }
    })

    options.appendChild(contain)

  } else if (data.type == "bitask") {
    const contain = document.createElement("div")
    const button1 = document.createElement("button");
    const button2 = document.createElement("button");

    button1.innerText = "SI";
    button2.innerText = "NO";
    button1.classList = "border-2 border-white hover:border-[#011059] rounded-xl px-10 hover:bg-[#011059] py-2 text-white hover:text-[#418cf1] transition-colors";
    button2.classList = "border-2 border-white hover:border-[#011059] rounded-xl px-10 hover:bg-[#011059] py-2 text-white hover:text-[#418cf1] transition-colors";
    contain.classList = "flex justify-start gap-10 px-2 mt-5  text-xl font-bold ";

    button1.addEventListener("click", () => {
      changeIntance(0);
    })

    button2.addEventListener("click", () => {
      changeIntance(1);
    })

    options.innerHTML = "";

    contain.appendChild(button1)
    contain.appendChild(button2)

    options.appendChild(contain)

  } else if (data.type == "solution") {
    options.innerHTML = "";

    const contain = document.createElement("div");

    contain.classList = "text-white h-full";

    contain.innerText = `${data.product}`

    options.appendChild(contain);

  }
}

let clockActive = false;

clock.addEventListener("click", (event) => {
  if (!clockBar.contains(event.target)) {
    clockActive = !clockActive;
    clockActive ? clockBar.style.display = "block" : clockBar.style.display = "none";
  }
})

document.addEventListener("click", (event) => {
  if (!clock.contains(event.target)) {
    clockActive = false;
    clockActive ? clockBar.style.display = "block" : clockBar.style.display = "none";
  }
  if (!menu.contains(event.target)) {
    menuActive = false;
    menuActive ? menuBar.style.display = "block" : menuBar.style.display = "none"

  }
})

let menuActive = false;

menu.addEventListener("click", () => {
  menuActive = !menuActive;
  menuActive ? menuBar.style.display = "block" : menuBar.style.display = "none"
})

help.addEventListener("mouseenter", () => {
  helpBar.style.display = "block"
})
help.addEventListener("mouseleave", () => {
  helpBar.style.display = "none"
})
