package Project;


public class Field {
    public char[][] matrix = new char[][] {
            {'-','-','-','-','-','-','F'},
            {'T','-','J','-','M','-','B'},
            {'!','-','-','!','-','-','!'},
            {'T','-','M','-','J','-','B'},
            {'F','-','-','-','-','-','-'},
    };

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

}
