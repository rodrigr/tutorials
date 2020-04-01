
let container = document.getElementById("container")

let box = document.createElement('DIV')
box.style.width = "75vw"
box.style.height = "75vh"
box.style.background = "gray"
box.id = "box"
box.classList.add("rounded")

container.appendChild(box)


for(let i = 0; i<10; i++){
	let div = document.createElement('DIV')
	div.style.width = "125px"
	div.style.height = "125px"
	div.style.background = `rgb(0,0,${i * 20})`
	div.classList.add('rounded')
	div.style.color ="white"
	div.classList.add("perfect-centering")
	div.style.cursor = "pointer"

	div.innerText = i + 1

	box.appendChild(div)
}

box.classList.add("flex")

let p = document.createElement('P')
p.style.height = "20px"
p.innerText = "pulsing box "
container.appendChild(p)
let p2 = document.createElement('P')
p2.style.height = "20px"
container.appendChild(p2)

document.querySelectorAll("#box>div").forEach(e => e.addEventListener("click",pulse))


function pulse(event){
	event.target.classList.toggle("pulse")

	if(event.target.classList.contains("pulse")){
		p.innerText += " " +  event.target.innerText
	}else{
		p.innerText = p.innerText.replace(event.target.innerText, "")
	}
	
}

document.querySelectorAll("#box>div").forEach(e => e.addEventListener("mouseenter",hover))

function hover(event){
	p2.innerText = "hovering box " +  event.target.innerText
}

document.querySelectorAll("#box>div").forEach(e => e.addEventListener("mouseleave",clear))

function clear(){
	p2.innerText = ""
}
