function pizza() {
    echo "A pizza $toppings"
    toppings=""
}
function cheese(){
    toppings="$toppings+cheese"
}
function peperoni(){
    toppings="$toppings+peperoni"
}

#cheesepizza
cheese
pizza

#peperoni pizza
peperoni
pizza

#double cheese pizza
cheese
cheese
pizza