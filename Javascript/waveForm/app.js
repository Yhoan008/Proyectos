const text_mail = document.querySelector('.text_email');
const text_pass = document.querySelector('.text_pass');
const form_mail = document.querySelector('.form_email');
const form_pass = document.querySelector('.form_pass');

text_mail.addEventListener('click',()=>{
    form_mail.focus();
})
text_pass.addEventListener('click',()=>{
    form_pass.focus();
})
form_mail.addEventListener('focus',()=>{
    text_mail.classList.add('active');
})
form_mail.addEventListener('blur',()=>{
    if(form_mail.value.length == 0 ){
        text_mail.classList.remove('active');
    }
})
form_pass.addEventListener('focus',()=>{
    text_pass.classList.add('active');
})
form_pass.addEventListener('blur',()=>{
    if(form_pass.value.length == 0){
        text_pass.classList.remove('active');
    }
})


divid=(texto,letra)=>{
    let nodo=`<div>${letra}</div>`;
    texto.innerHTML=texto.innerHTML+nodo;
}

let letras_mail=text_mail.innerText.split('');
text_mail.innerHTML='';

let letras_pass=text_pass.innerText.split('');
text_pass.innerHTML='';

letras_mail.forEach((letra)=>{
    divid(text_mail,letra);
});

letras_pass.forEach((letra)=>{
    divid(text_pass,letra)
})


const textMail = document.querySelectorAll('.text_email div');
let num=30;

for (let i = 0; i < textMail.length; i++) {
    let count = i/num;
    textMail[i].style.transitionDelay=`${count}s`;
}

const textPass = document.querySelectorAll('.text_pass div');

for (let i = 0; i < textPass.length; i++) {
    let count = i/num;
    textPass[i].style.transitionDelay=`${count}s`;
}