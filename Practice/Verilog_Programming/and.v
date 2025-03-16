module And_Gate (
    input wire A,
    input wire B,
    output wire Y
);

    assign Y = A & B;
endmodule

module And_Gate_tb;

    reg A_tb,B_tb;
    wire Y_tb;
    And_Gate uut (
        .A(A_tb),
        .B(B_tb),
        .Y(Y_tb)
    );
    initial begin
        A_tb=0; B_tb=0; #10
        A_tb=0; B_tb=1; #10
        A_tb=1; B_tb=0; #10
        A_tb=1; B_tb=1; #10
        $finish;
    end
    initial begin
        $dumpfile("outputwave.vcd");
        $dumpvars(0,And_Gate_tb);
    end
    initial begin
        $monitor("At time %t A = %b B = %b Y = %b",$time,A_tb,B_tb,Y_tb);
    end
    
endmodule