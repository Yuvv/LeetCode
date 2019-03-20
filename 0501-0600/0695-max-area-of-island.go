// 求矩阵中区域数
// https://leetcode.com/problems/max-area-of-island/description/
func maxAreaOfIsland(grid [][]int) int {
    max := 0
    h, w := len(grid), len(grid[0])
    visited := make([][]int, h)
    for i := range visited {
        visited[i] = make([]int, w)
    }

    for i, row := range grid {
        for j := range row {
            area := getArea(i, j, grid, visited, h, w)
            if area > max {
                max = area
            }
        }
    }
    return max
}

func getArea(i int, j int, grid [][]int, visited [][]int, h int, w int) int {
    if i < 0 || i >= h || j < 0 || j >= w || grid[i][j] != 1 || visited[i][j] == 1 {
        return 0
    }
    area := 1
    visited[i][j] = 1
    area += getArea(i-1, j, grid, visited, h, w)
    area += getArea(i+1, j, grid, visited, h, w)
    area += getArea(i, j-1, grid, visited, h, w)
    area += getArea(i, j+1, grid, visited, h, w)

    return area
}