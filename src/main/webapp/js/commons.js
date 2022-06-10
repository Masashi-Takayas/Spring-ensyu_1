function openModal() {
    let gray_out = document.getElementById("fadeLayer");
    gray_out.style.visibility = "visible";
    setTimeout(addClass, 200);
}

function closeModal() {
    let modal = document.getElementById('modal');
    let gray_out = document.getElementById("fadeLayer");
    modal.classList.remove('is-show');
    gray_out.style.visibility ="hidden";
}

function addClass() {
    let modal = document.getElementById('modal');
    modal.classList.add('is-show');
}

function Point(){
    this.x = 0;
    this.y = 0;
}

Point.prototype.distance = function(p){
    var q = new Point();
    q.x = p.x - this.x;
    q.y = p.y - this.y;
    return q;
};

Point.prototype.length = function(){
    return Math.sqrt(this.x * this.x + this.y * this.y);
};

Point.prototype.normalize = function(){
    var i = this.length();
    if(i > 0){
        var j = 1 / i;
        this.x *= j;
        this.y *= j;
    }
};