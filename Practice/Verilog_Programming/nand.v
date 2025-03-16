module NAND (
    input wire A,
    input wire B,
    output wire Y
);

    assign Y = ~(A & B);
    
endmodule

module NAND_TB;

    reg a,b;
    wire y;

    NAND uut (.A(a),.B(b),.Y(y));

    initial begin
        a = 0; b = 0; #10;
        a = 0; b = 1; #10;
        a = 1; b = 0; #10;
        a = 1; b = 1; #10;
        $finish;
    end
    initial begin
        $dumpfile("outputwave.vcd");
        $dumpvars(0,NAND_TB);
    end
    initial begin
        $monitor("A = %b B = %b Y = %b at Time=%t",a,b,y,$time);
    end
    
endmodule