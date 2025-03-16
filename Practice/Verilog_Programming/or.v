module OR_Gate (
    input wire A,
    input wire B,
    output wire Y
);

    assign Y = A | B;
    
endmodule

module OR_Gate_TB;
    reg A_;
    reg B_;
    wire Y_;

    OR_Gate uut (
        .A(A_),
        .B(B_),
        .Y(Y_)
    );
    initial begin
        A_ = 0; B_ = 0; #10;
        A_ = 0; B_ = 1; #10;
        A_ = 1; B_ = 0; #10;
        A_ = 1; B_ = 1; #10;
        $finish;
    end
    initial begin
        $dumpfile("outputwave.vcd");
        $dumpvars(0,OR_Gate_TB);
    end
    initial begin
        $monitor("A = %b B = %b Y = %b at T = %t",A_,B_,Y_,$time);
    end
    
endmodule