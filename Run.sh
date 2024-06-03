# cd JAVA


filename="$1"
echo "$filename is Now Running"
printf "\n\n"
g++ -o a.out "$filename" -lstdc++
./a.out
printf "\n\n\n"

printf "End of Program"

# g++ -o a.out input_file.cpp -lstdc++
# ./a.out
