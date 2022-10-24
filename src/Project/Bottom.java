package Project;

public class Bottom {

    String[] adc = new String[]{"Ashe","Caytlin","Vayne"};
    public int leftSideRow = 4;
    public int leftSideCol = 6;
    public int rightSideRow = 2;
    public int rightSideCol = 6;

    int coins = 0;
    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public int ad = 100;

    public String[] getAdc() {
        return adc;
    }

    public void setAdc(String[] adc) {
        this.adc[0] = "Ashe";
        this.adc[1] = "Vayne";
        this.adc[2] = "Caytlin";
    }

    public int getLeftSideRow() {
        return leftSideRow;
    }

    public void setLeftSideRow(int leftSideRow) {
        this.leftSideRow = leftSideRow;
    }

    public int getLeftSideCol() {
        return leftSideCol;
    }

    public void setLeftSideCol(int leftSideCol) {
        this.leftSideCol = leftSideCol;
    }

    public int getRightSideRow() {
        return rightSideRow;
    }

    public void setRightSideRow(int rightSideRow) {
        this.rightSideRow = rightSideRow;
    }

    public int getRightSideCol() {
        return rightSideCol;
    }

    public void setRightSideCol(int rightSideCol) {
        this.rightSideCol = rightSideCol;
    }

    public String getChamp (int index) {
        if (index == 1) {
            return adc[0];
        } else if (index == 2) {
            return adc[1];
        } else if (index == 3) {
            return adc[2];
        }
        return null;
    }
    public void adcs () {
        for (String current : adc) {
            System.out.print(current + " ");
        }
    }
}
