const progress = document.querySelector(".yesProgress");
const circle = document.querySelectorAll(".circle");
const prev = document.getElementById("prev");
const next = document.getElementById("next");

let count=0;

cambiarEstado = (count) =>{
    switch (count){
        case 0 :
            progress.style.transform = "translate(0%)";
            circle[1].style.border="4px solid gray";
            prev.setAttribute('disabled','');
            break;
        case 1:
            progress.style.transform = "translate(33%)";
            circle[1].style.border="4px solid #04f";
            circle[2].style.border="4px solid gray";
            prev.removeAttribute('disabled');
            break;

        case 2:
            progress.style.transform = "translate(66%)";
            circle[2].style.border="4px solid #04f";
            circle[3].style.border="4px solid gray";
            next.removeAttribute('disabled');
            break;
        case 3:
            progress.style.transform = "translate(100%)";
            circle[3].style.border="4px solid #04f";
            next.setAttribute('disabled','');
            break;
    }
}

prev.addEventListener('click',function(event){
    count--;
    cambiarEstado(count);
})

next.addEventListener('click',function(event){
    count++;
    cambiarEstado(count);
})
