let img = document.querySelectorAll('.img');

function quitarClass(){
    for(let i=0;i<5;i++){
        img[i].classList.remove("active");
    }
}

for (let i = 0; i < 5; i++) {
    img[i].addEventListener('click',(event)=>{
        quitarClass();
        img[i].classList.toggle('active')
    })
}


