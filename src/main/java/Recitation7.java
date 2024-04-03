public class Recitation7 {
    /*
     * You may add any private helper method you see necessary,
     * but you may NOT change the signatures of the methods below.
     */
    public static boolean lastItemReachable(int[] hopList){
        if ((hopList.length == 1)){
            return true;
        }
        int hop = hopList[0];
        boolean result = true;
        int previousHop = 0;
        while(result){
            if(hop == hopList[hopList.length - 1]){
                return result;
            }
            else if(previousHop + hop >= hopList.length - 1 || hop == 0){
                result = false;
            }
            else {
                previousHop = hop + previousHop;
                hop = hopList[hop];
            }
        }
        return result;

    }

    public static int[] slidingWindowMin(int[] numberList, int windowSize){
        int[] maxNumbers = new int[numberList.length - windowSize + 1];
        if(windowSize > numberList.length){
            return new int[0];
        }
        int rightWindow;
        int min = numberList[0];
        for(int leftWindow = 0; leftWindow < numberList.length - windowSize + 1; leftWindow ++){
            rightWindow = leftWindow + windowSize - 1;
            min = numberList[leftWindow];
            for(int i = leftWindow; i < rightWindow + 1; i++){
                if(min > numberList[i]){
                    min = numberList[i];
                }
            }
            maxNumbers[leftWindow] = min;
        }

        return maxNumbers;
    }
}
