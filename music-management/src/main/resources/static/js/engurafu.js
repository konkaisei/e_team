// グラフを描画するためのキャンバス要素を生成する関数
    const result = document.getElementById("js-result");
    const createCanvas = () => {
        const canvas = document.createElement("canvas");
        canvas.width = 200;
        canvas.height = 100;
        result.appendChild(canvas);
        return canvas;
    };
    const doughnutChart = new Chart(createCanvas(), {
    type: "doughnut",
    data: {
    labels: ["Red", "Blue"],
    datasets: [{
        data: [300, 50],
        backgroundColor: ["rgb(255, 99, 132)", "rgb(54, 162, 235)"],
    }],
    },
    options: {
    cutout: "50%", // ドーナツの内径を設定
    },
});