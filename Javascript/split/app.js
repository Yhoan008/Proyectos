const zilla = document.querySelector('.zilla');
const kong = document.querySelector('.kong');

zilla.addEventListener('mouseenter',()=>{
    zilla.classList.add('active');
    kong.classList.add('noActive');
})

zilla.addEventListener('mouseleave',()=>{
    zilla.classList.remove('active');
    kong.classList.remove('noActive');
})

kong.addEventListener('mouseenter',()=>{
    kong.classList.add('active');
    zilla.classList.add('noActive');
})

kong.addEventListener('mouseleave',()=>{
    kong.classList.remove('active');
    zilla.classList.remove('noActive');
})
