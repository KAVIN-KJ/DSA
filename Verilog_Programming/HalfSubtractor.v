module HalfSubtractor (
    input wire a,b,
    output wire d,br
);
    
    assign d = a^b;
    assign br = ~a & b;

endmodule

module TB;

    reg a,b;
    wire br,d;

    HalfSubtractor uut (.a(a),.b(b),.d(d),.br(br)); 

    initial begin
        a = 0; b = 0; #10;
        a = 0; b = 1; #10;
        a = 1; b = 0; #10;
        a = 1; b = 1; #10;
    end

    initial begin
        $dumpfile("output.vcd");
        $dumpvars(0,TB);
    end

    initial begin
        $monitor("A = %b | B = %b | Diff = %b | Borrow = %b",a,b,d,br);
    end

    
endmodule