public class MazePathFinder{
    public boolean isMazeSolvable(int[][] maze){
        int x, y, startX, startY, endX, endY;
        startX = -1;
        startY = -1;
        endX = -1;
        endY = -1;
      
        // First find start 'S' position
        // along with that also look for end 
        // position 'E'
        for(x=0; x < maze.length; x++){
            for(y=0; y < maze[x].length; y++){
                if(maze[x][y]== 'S'){
                    startX = x;
                    startY = y;
                }else if(maze[x][y] == 'E'){
                    endX = x;
                    endY = y;
                }
            }
        }
        
        // If we don't have start or end position then
        if(startX == -1 || endX == -1) return false;
        
        // call to recursive function
        return exploreMaze(maze, startX, startY);
    } 

    private boolean exploreMaze(int[][] maze, int sX, int sY){

        // If we are out of grid return false.
        if(sX < 0 || sX >= maze.length || sY < 0 || sY >= maze[sX].length) return false;
        
        // Check if current position is obstacle
        if(maze[sX][sY] == '*') return false; 
        
        // If end found return true
        if(maze[sX][sY] == 'E') return true;
        
        // Set current position as obstacle to avoid infinite loop
        maze[sX][sY] = '*';
        
        // Check for neighbour positions
        if (exploreMaze(maze, sX, sY+1)) return true;
        if (exploreMaze(maze, sX+1, sY)) return true;
        if (exploreMaze(maze, sX-1, sY)) return true;
        if (exploreMaze(maze, sX, sY-1)) return true;
        
        return false;
    }
}