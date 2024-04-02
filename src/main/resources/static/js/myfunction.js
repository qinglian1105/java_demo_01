// Chart.js demo: bar chart
function myChartJsBar() {
  const chartElement = document.getElementsByClassName("js-chartjs-bars");
  const data = {
    labels: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
    datasets: [
      {
        label: "每週交易量",
        borderWidth: 1,
        borderColor: "rgba(0,0,0,0)",
        backgroundColor: "rgba(51,202,185,0.5)",
        hoverBackgroundColor: "rgba(51,202,185,0.7)",
        hoverBorderColor: "rgba(0,0,0,0)",
        data: [2600, 1200, 1300, 3500, 4900, 3200, 1800],
      },
    ],
  };
  new Chart(chartElement, {
    type: "bar",
    data: data,
  });
}

// Chart.js demo: line chart
function myChartJsLine() {
  const chartElement = document.getElementsByClassName("js-chartjs-lines");
  const data = {
    labels: [
      "2012",
      "2013",
      "2014",
      "2015",
      "2016",
      "2017",
      "2018",
      "2019",
      "2020",
      "2021",
      "2022",
      "2023",
    ],
    datasets: [
      {
        label: "交易金額(單位:萬)",
        data: [22, 26, 42, 34, 47, 38, 25, 42, 49, 37, 46, 58],
        borderColor: "#358ed7",
        backgroundColor: "rgba(53, 142, 215, 0.175)",
        borderWidth: 1,
        fill: false,
        lineTension: 0.5,
      },
    ],
  };
  new Chart(chartElement, {
    type: "line",
    data: data,
  });
}

// Romdanly generate rgb-color list
function getRandomRgbList(n) {
  var colorlist = [];
  for (let i = 0; i < n; i++) {
    var num = Math.round(0xffffff * Math.random());
    var r = num >> 16;
    var g = (num >> 8) & 255;
    var b = num & 255;
    colorlist.push("rgb(" + r + ", " + g + ", " + b + ")");
  }
  return colorlist;
}

// Chart.js demo: pie chart
function myChartJsDoughnut(v_labels, v_data) {
  var colorlist = getRandomRgbList(v_labels.length);
  var chartElement = document.getElementsByClassName("js-chartjs-pie");
  var data = {
    labels: v_labels,
    datasets: [
      {
        label: "",
        data: v_data,
        backgroundColor: colorlist,
      },
    ],
  };
  new Chart(chartElement, {
    type: "doughnut",
    data: data,
  });
}

// New add user to DB
function newAddToDB() {
  var username = document.getElementById("username").value;
  var age = document.getElementById("age").value;
  var weight = document.getElementById("weight").value;
  var height = document.getElementById("height").value;  
  var data = JSON.stringify({ username: username, age: age, height: height, weight: weight });
  console.log("Data", data);
  axios({
    method: "post",
    url: "http://localhost:8080/insertuser",
    data: data,
    headers: {"Content-type": "application/json; charset=UTF-8",}
  })
    .then((response) => console.log(response))
    .catch((error) => console.log(error));  
}

// Clean inputs
function clearnInputs() {
  document.getElementById("username").value = "";
  document.getElementById("age").value = "";
  document.getElementById("height").value = "";
  document.getElementById("weight").value = "";
}
