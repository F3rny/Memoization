import java.util.HashMap;
import java.util.Arrays;
import java.util.*;

public class Started{
    public static void main(String[] args){
        HashMap<String, Long> map = new HashMap<>();
        //System.out.println(fib(50));
        // System.out.println(gridTraveler(1, 1, map));
        // System.out.println(gridTraveler(0, 1, map));
        // System.out.println(gridTraveler(2, 3, map));
        // System.out.println(gridTraveler(3, 2, map));
        // System.out.println(gridTraveler(3, 3, map));
        // System.out.println(gridTraveler(18, 18, map));

        // System.out.println(canSum(7, new int[] {2,3}));
        // System.out.println(canSum(7, new int[] {5,3,4,7}));
        // System.out.println(canSum(7, new int[] {2,4}));
        // System.out.println(canSum(8, new int[] {2,3,5}));
        // System.out.println(canSum(300, new int[] {7,14}));

        // System.out.println(Arrays.toString(howSum(7, new int[] {2,3})));
        // System.out.println(Arrays.toString(howSum(7, new int[] {5,3,4,7})));
        // System.out.println(Arrays.toString(howSum(7, new int[] {2,4})));
        // System.out.println(Arrays.toString(howSum(8, new int[] {2,3,5})));
        // System.out.println(Arrays.toString(howSum(300, new int[] {7,14})));
    
        // System.out.println(Arrays.toString(bestSum(7, new int[] {5,3,4,7})));
        // System.out.println(Arrays.toString(bestSum(7, new int[] {2,4})));
        // System.out.println(Arrays.toString(bestSum(8, new int[] {2,3,5})));
        // System.out.println(Arrays.toString(bestSum(100, new int[] {1,2,5,25})));

        // System.out.println(canConstruct("abcdef" , new String[]{"ab" , "abc" , "cd", "def", "abcd"}));
        // System.out.println(canConstruct("skateboard" , new String[]{"s" , "ska" , "bo", "rd", "ate", "t", "sk", "boar"}));
        // System.out.println(canConstruct("abc" , new String[]{"a" , "b" , "c"}));
        // System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[]{"e" , "eeee" , "eeeee", "eeeeee", "eeeeeee", "eeeeeeeee", "eeeee"}));

        // System.out.println(countConstruct("abcdef" , new String[]{"ab" , "abc" , "cd", "def", "abcd"}));
        // System.out.println(countConstruct("skateboard" , new String[]{"s" , "ska" , "bo", "rd", "ate", "t", "sk", "boar"}));
        // System.out.println(countConstruct("abc" , new String[]{"a" , "b" , "c"}));
        // System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[]{"e" , "eeee" , "eeeee", "eeeeee", "eeeeeee", "eeeeeeeee", "eeeee"}));

        // System.out.println(Arrays.deepToString(allConstruct("abcdef" , new String[]{"ab" , "abc" , "cd", "def", "abcd", "ef", "c"})));
        // System.out.println(Arrays.deepToString(allConstruct("skateboard" , new String[]{"s" , "ska" , "bo", "rd", "ate", "t", "sk", "boar"})));
        // System.out.println(Arrays.deepToString(allConstruct("" , new String[]{"cat" , "dog" , "cake"})));
        // System.out.println(Arrays.deepToString(allConstruct("eeeeeeeeeaeeeeeeeeeeeef" , new String[]{"e" , "eeee" , "eeeee", "eeeeee", "eeeeeee", "eeeeeeeee", "eeeee"})));
        // //  To print the content of the arrays, you can use Arrays.deepToString() method which is specifically designed to print the content of multi-dimensional arrays. 
        
        // System.out.println(canSumT(7, new int[] {2,3}));
        // System.out.println(canSumT(7, new int[] {5,3,4,7}));
        // System.out.println(canSumT(7, new int[] {2,4}));
        // System.out.println(canSumT(8, new int[] {2,3,5}));
        // System.out.println(canSumT(300, new int[] {7,14}));

        System.out.println(canConstructT("abcdef" , new String[]{"ab" , "abc" , "cd", "def", "abcd"}));
        System.out.println(canConstructT("skateboard" , new String[]{"s" , "ska" , "bo", "rd", "ate", "t", "sk", "boar"}));
        System.out.println(canConstructT("abc" , new String[]{"a" , "b" , "c"}));
        System.out.println(canConstructT("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef" , new String[]{"e" , "eeee" , "eeeee", "eeeeee", "eeeeeee", "eeeeeeeee", "eeeee"}));


       
    }

    // memoization
    public static long fib(int n){
        HashMap<Integer, Long> mp = new HashMap<Integer, Long>();
        if(n <= 2) return (long) 1;
        if(mp.containsKey(n)){
        return mp.get(n);
        }
        long result = fib(n -1) + fib(n -2);
        mp.put(n, result);
        return result;
    }
    public static Long gridTraveler(int m, int n, HashMap<String, Long> map){
        String key = m + "," + n ;
        if(map.containsKey(key)){
            return map.get(key);
        }
        if( m == 1 && n == 1) return (long) 1;
        if( m == 0 || n == 0) return (long) 0;
        long result = gridTraveler(m -1, n, map) + gridTraveler(m, n -1, map);
        map.put(key, result);
        return result;
    }
    public static boolean canSum(int targetSum, int[] numbers){
        HashMap<Integer, Boolean> map = new HashMap<>();
        if(map.containsKey(targetSum)) return map.get(targetSum);
        if(targetSum == 0) return true;
        if(targetSum < 0 ) return false;
        
        for(int num : numbers){
            int remainder = targetSum - num;
            if( canSum(remainder, numbers) == true) {
                map.put(targetSum, true);
                return true;
            }
        }
        map.put(targetSum, false);
        return false;
    }
    public static int[] howSum(int targetSum, int[] numbers){
        HashMap<Integer, int[]> map = new HashMap<>();
        if(map.containsKey(targetSum)) return map.get(targetSum);
        if(targetSum == 0) return new int[] {};
        if(targetSum < 0) return null;

        for(int num : numbers){
            int remainder = targetSum - num;
            int[] remainderResult = howSum(remainder, numbers);
            if(remainderResult != null){
                int[] result = new int[remainderResult.length + 1];
                System.arraycopy(remainderResult, 0, result, 0, remainderResult.length);
                result[result.length - 1] = num;
                map.put(targetSum, result);
                return result; 
            }
        }
        map.put(targetSum, null);
        return null;
    }
    public static int[] bestSum(int targetSum, int[] numbers){
        HashMap<Integer, int[]> map = new HashMap<>();
        if(map.containsKey(targetSum))return map.get(targetSum);
        if(targetSum == 0) return new int[] {};
        if(targetSum < 0) return null;

        int[] shortestCombination = null;

        for( int num : numbers){
            int remainder = targetSum - num;
            int[] remainderCombination = bestSum(remainder , numbers);
            if(remainderCombination != null){
                int[] result = new int[remainderCombination.length  + 1];
                System.arraycopy(remainderCombination, 0 , result, 0 , remainderCombination.length);
                result[result.length - 1] = num;
                map.put(targetSum, result);
                // if the combination is shortest than current "shortest", update it
                if(shortestCombination == null || result.length < shortestCombination.length){
                    shortestCombination = result;
                }
                
            }
        }
        return shortestCombination;

    }
    public static boolean canConstruct(String target, String[] wordBank){
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        if(map.containsKey(target)) return map.get(target);
        if(target == "") return true;
        
        for( String word : wordBank){
            if(target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                if(canConstruct(suffix, wordBank) == true){
                    map.put(target, true);
                    return true;

                }
            }
        }
        map.put(target, false);
        return false;
    
    }
    public static int countConstruct(String target, String[] wordBank){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        if(map.containsKey(target)) return map.get(target);
        if( target == "") return 1;

        int total = 0;
        for(String word : wordBank){
            if(target.indexOf(word) == 0){
                int numWaysForRest = countConstruct(target.substring(word.length()), wordBank);
                total = numWaysForRest;
            }
        }
        map.put(target, total);
        return total;

    }

    public static String[][] allConstruct(String target, String[] wordBank){
        HashMap<String, String[][]> map = new HashMap<>();
        if(map.containsKey(target)) return map.get(target);
        if(target.equals("")) return new String[][] {};

        ArrayList<String[]> result = new ArrayList<>();

        for(String word : wordBank){
            if(target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                String[][] suffixWays = allConstruct(suffix, wordBank);
                
                if(suffixWays.length > 0){
                    for(String[] way : suffixWays){
                        String[] targetWay = new String[way.length + 1];
                        targetWay[0] = word;
                        System.arraycopy(way, 0, targetWay, 1, way.length);
                        result.add(targetWay);
                    }
                } 
                else{
                    result.add(new String[] { word });
                    }
                }
            }
            map.put(target, result.toArray(new String[result.size()][]));  
            return result.toArray(new String[result.size()][]);
        }
        public static boolean canSumT(int targetSum,int[] numbers){
            boolean[] table = new boolean[targetSum + 1];
            Arrays.fill(table , false);
            table[0] = true;
            for(int i = 0; i <= targetSum; i++){
                if(table[i] == true){
                    for(int num : numbers){
                        if((i + num) <= targetSum) // checks if i + num is not out of bounds 
                            table[i + num] = true;
                    }
                }
            }
            return table[targetSum];
        }

        public static boolean canConstructT(String target, String[] wordBank){
            boolean[] table = new boolean[target.length() + 1];
            Arrays.fill(table, false);
            table[0] = true;

            for(int i = 0; i <= target.length(); i++){
                if(table[i] == true){
                    for(String word : wordBank){
                        // if the word matches the characters startning at position i
                        if(i + word.length() <= target.length() && target.substring(i, i + word.length()).equals(word)){
                            table[i + word.length()] = true;
                        }
                    }
                }
            }
            return table[target.length()];
    }
}