const fs = require("fs");
const { connected } = require("process");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().split("\n");

let testCases = Number(input[0]);
// 첫 입력값
let line = 1;
// 0 은 TC 이므로 X,Y,A 값 받기위해

for (let TC = 0; TC < testCases; TC++) {
  let [X, Y, A] = input[line].split(" ").map(Number);

  let graph = [];

  for (let i = 0; i < Y; i++) {
    graph[i] = new Array(X);
    // 배추를 심을 밭의 2차원 배열
  }

  // console.log(graph);

  for (let i = 1; i <= A; i++) {
    let [y, x] = input[line + i].split(" ").map(Number);
    graph[x][y] = 1;
    // 배추를 심은 곳에 1
  }

  // console.log(graph);

  let counter = 0;

  for (let i = 0; i < Y; i++) {
    for (let j = 0; j < X; j++) {
      if (dfs(graph, Y, X, i, j)) counter += 1;
      // (0,0)부터 dfs 실행. true 를 받으면 그룹 갯수이므로 counter 를 ++
    }
  }

  line += A + 1;
  // 다음 라인을 받아야 하므로 A 를 더함

  console.log(counter);
}

function dfs(graph, Y, X, i, j) {
  if (i < 0 || j < 0 || Y <= i || X <= j) {
    // 밭을 넘어갔을 경우 false
    return false;
  }

  if (graph[i][j] == 1) {
    //해당위치에 배추가 존재할 경우
    graph[i][j] = -1;
    // 방문표시 대신 -1 로 지움

    dfs(graph, Y, X, i - 1, j);
    dfs(graph, Y, X, i, j - 1);
    dfs(graph, Y, X, i + 1, j);
    dfs(graph, Y, X, i, j + 1);
    // 4방향으로 dfs 실행

    return true;
  }

  return false;
  // 존재하지 않을 경우 false
}
