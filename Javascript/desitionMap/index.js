const question = document.getElementById("question");
const help = document.getElementById("help");
const back = document.getElementById("back");
const helpBar = document.getElementById("helpBar");
const options = document.getElementById("options");

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
    draw(instance, changeIntance)
    history = [...history, instance]
  }

  draw(data, changeIntance)
  history = [data]


  back.addEventListener("click", () => {
    if (history.length <= 1) {
      console.log("retorno invalido")
    } else {
      history = history.slice(0, -1)
      instance = history[history.length - 1]
      draw(instance, changeIntance)
    }
  })


})

function draw(data, changeIntance) {
  if (data === undefined) { console.error("la instancia es invalida") }
  if (data.help !== undefined) {
    help.style.display = "block";
    helpBar.innerText = `${data.help}`
  } else {
    help.style.display = "none";
  }
  question.innerText = `${data.question}`;

  if (data.type == "multitask") {

    const contain = document.createElement("select");
    const defa = document.createElement("option");

    options.innerHTML = "";

    contain.classList = "py-2 px-5  mt-5 rounded font-bold text-xl bg-[#011059] text-[#418cf1]";
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

help.addEventListener("mouseenter", () => {
  helpBar.style.display = "block"
})
help.addEventListener("mouseleave", () => {
  helpBar.style.display = "none"
})
