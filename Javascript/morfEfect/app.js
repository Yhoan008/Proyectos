const body = document.querySelector("body");
const btn = document.querySelector(".btn");

let count=1;

btn.addEventListener('click',()=>{

    if(count < 4){
        count++;
        body.style.backgroundImage=`url(img/fondo${count}.jpg)`;
    }else{
        count=1;
        body.style.backgroundImage=`url(img/fondo${count}.jpg)`;
    }

})
