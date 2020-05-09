import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    static List<String> reverseList(String[] str) {
        ArrayList<String> result = new ArrayList<>(Arrays.asList(str));
        int n = result.size() - 1;
        for (int i = 0; i < n; i++) {
            result.add(i, result.remove(n));
        }
//        Collections.reverse(result);
        return result;
    }

    static String[] reverseArray(String[] str) {
        if (str == null || str.length <= 1) {
            return str;
        }
        int n = str.length;
        for (int i = 0; i < (n / 2); i++) {
            String temp = str[i];
            str[i] = str[n - i - 1];
            str[n - i - 1] = temp;
        }
        return str;
    }

    static void findFirstNonRepeatableAfterJava8(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);
        }
        System.out.println(map.entrySet().stream().filter(c -> c.getValue() == 1).findFirst().get().getKey());
    }

    static void findFirstNonRepetableBeforeJava8(String str) {
        char[] string = str.toCharArray();
        char[] count = new char[256];
        for (char c : string) {
            count[c]++;
        }
        for (char c : string) {
            if (count[c] == 1) {
                System.out.println(c);
                break;
            }
        }
    }

    static void findMaximumAfterJava8(int[] nb) {
        Optional<Integer> max = Arrays.stream(nb).boxed().max(Integer::compare);
        max.ifPresent(System.out::println);
    }

    static void findMaximumBeforeJava8(int[] nb) {
        int max = nb[0];
        for (int i = 1; i < (nb.length - 1); i++) {
            if (nb[i] > max) {
                max = nb[i];
            }
        }
        System.out.println(max);
    }

    static void countElementsAfterJava8(int[] nb) {
        List<Integer> numbers = Arrays.stream(nb).boxed().collect(Collectors.toList());
        System.out.println(numbers.size());
        System.out.println(numbers.stream().count());
    }

    static void countElementsBeforeJava8(int[] nb) {
        int count = 0;
        for (int i = 0; i < nb.length; i++) {
            count++;
        }
        System.out.println(count);
    }

    static void findDuplicatesAfterJava8(int[] nb) {
        List<Integer> numbers = Arrays.stream(nb).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<Integer>();
        numbers.stream().filter(n -> !set.add(n)).forEach(System.out::println);
    }

    static void findDuplicatesBeforeJava8(int[] nb) {
        for (int i = 0; i < (nb.length - 1); i++) {
            for (int j = (i + 1); j < nb.length; j++) {
                if (nb[i] == nb[j]) {
                    System.out.println(nb[i]);
                    break;
                }
            }
        }
    }

    static void startingWith1BeforeJava8(int[] nb) {
        for (int n : nb) {
            if (String.valueOf(n).startsWith("1")) {
                System.out.println(n);
            }
        }
    }

    static void startingWith1AfterJava8(int[] nb) {
        List<Integer> numbers = Arrays.stream(nb).boxed().collect(Collectors.toList());
        numbers.stream().filter(n -> String.valueOf(n).startsWith("1")).forEach(System.out::println);
    }

    static void areEvenAfterJava8(int[] nb) {
        List<Integer> numbers = Arrays.stream(nb).boxed().collect(Collectors.toList());
        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }

    static void areEvenBeforeJava8(int[] nb) {
        for (int n : nb) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }
    }

    static boolean isAnagram(String s1, String s2) {
        int a = s1.length();
        int b = s2.length();
        if (a != b) {
            return false;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return (Arrays.equals(str1, str2));
    }

    static int fib(int n) {
        if (n >= 0 && n < 2) {
            return n;
        }
        int a = 0;
        int b = 1;
        while (n-- >= 2) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    static int fibRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return (fibRecursive(n - 1) + fibRecursive(n - 2));
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
