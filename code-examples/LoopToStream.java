// Converting Loops to Streams - Before and After

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoopToStream {
    
    // ❌ OLD WAY - Traditional Loop
    public List<String> processNamesOld(List<String> names) {
        List<String> result = new ArrayList<>();
        for (String name : names) {
            if (name != null && name.length() > 3) {
                String upper = name.toUpperCase();
                result.add(upper);
            }
        }
        return result;
    }
    
    // ✅ NEW WAY - Stream API
    public List<String> processNamesNew(List<String> names) {
        return names.stream()
            .filter(name -> name != null && name.length() > 3)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }
    
    // ❌ OLD WAY - Finding maximum
    public int findMaxOld(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    // ✅ NEW WAY - Stream API
    public int findMaxNew(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .max()
            .orElse(Integer.MIN_VALUE);
    }
    
    // ❌ OLD WAY - Sum of even numbers
    public int sumEvenOld(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        return sum;
    }
    
    // ✅ NEW WAY - Stream API
    public int sumEvenNew(List<Integer> numbers) {
        return numbers.stream()
            .filter(num -> num % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();
    }
    
    // ❌ OLD WAY - Group by first letter
    public void groupByFirstLetterOld(List<String> names) {
        List<String> aNames = new ArrayList<>();
        List<String> bNames = new ArrayList<>();
        List<String> otherNames = new ArrayList<>();
        
        for (String name : names) {
            if (name != null && !name.isEmpty()) {
                char first = name.charAt(0);
                if (first == 'A' || first == 'a') {
                    aNames.add(name);
                } else if (first == 'B' || first == 'b') {
                    bNames.add(name);
                } else {
                    otherNames.add(name);
                }
            }
        }
    }
    
    // ✅ NEW WAY - Stream API with grouping
    public void groupByFirstLetterNew(List<String> names) {
        var grouped = names.stream()
            .filter(name -> name != null && !name.isEmpty())
            .collect(Collectors.groupingBy(
                name -> Character.toUpperCase(name.charAt(0))
            ));
    }
    
    // Benefits of Streams:
    // - More readable and declarative
    // - Easier to parallelize
    // - Functional programming style
    // - Less boilerplate code
    // - Better for complex transformations
}

