setTimeout(function() {
  document.getElementById("bgcolor").style.backgroundColor = "#2D2058";
  setTimeout(function() {
    const div = document.getElementById("symbol");
    div.remove();
  },3000);
}, 1500);

