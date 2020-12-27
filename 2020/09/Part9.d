import std.stdio;
import std.file;
import std.array;
import std.conv;
import std.algorithm.iteration;
import std.algorithm.searching;

void main() {
    int preambleLength = 25;
    long[] numbers = readText("input.txt").split("\n").map!(to!long).array();
    iloop: for(int i = preambleLength; i < numbers.length; i++) {
        for(int j = i-preambleLength; j < i; j++) {
            for(int k = j+1; k < i; k++) {
                if(numbers[j]+numbers[k]==numbers[i]) {
                    //writeln(to!string(i) ~ ": " ~ to!string(numbers[j]) ~ "+" ~ to!string(numbers[k]) ~ "=" ~ to!string(numbers[i]));
                    continue iloop; 
                }
            }
        }
        writeln(to!string(i) ~ ": " ~ to!string(numbers[i])); //
        for(int j = 0; j < i; j++) {
            int k = j;
            long sum = numbers[j];
            long[] sumNumbers = [numbers[j]];
            while(sum < numbers[i]) {
                k++;
                sum += numbers[k];
                sumNumbers ~= numbers[k];
            }
            if (sum == numbers[i]) {
                writeln(to!string(sum) ~ ": " ~ to!string(sumNumbers.minElement) ~ "-" ~ to!string(sumNumbers.maxElement) ~ " (" ~ to!string(sumNumbers.minElement + sumNumbers.maxElement) ~ ") : " ~ to!string(sumNumbers));
            }
        }
    }
}

