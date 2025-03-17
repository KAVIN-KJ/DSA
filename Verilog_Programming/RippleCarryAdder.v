module FullAdder (
    input wire a,b,cin,output wire sum,cout
);

    assign sum = a^b^cin;
    assign cout = a&b | b&cin | cin&a;
    
endmodule


module RippleCarryAdder (
    input wire [3:0] A,B,
    input wire cin,
    output wire [4:0]Sum
);

    wire c0,c1,c2;
    wire [3:0]S;
    wire cout;
    FullAdder FA0 (A[0],B[0],cin,S[0],c0);
    FullAdder FA1 (A[1],B[1],c0,S[1],c1);
    FullAdder FA2 (A[2],B[2],c1,S[2],c2);
    FullAdder FA3 (A[3],B[3],c2,S[3],cout);
    assign Sum = {cout,S};
    
endmodule

module TB;

    reg [3:0]a,b;
    reg cin;
    wire [4:0]s;

    RippleCarryAdder uut (.A(a),.B(b),.cin(cin),.Sum(s));

    initial begin
        a = 4'b1010; b = 4'b0101; cin = 0; #10;
        a = 4'b1111; b = 4'b0011; cin = 0; #10;
        a = 4'b1111; b = 4'b1111; cin = 0; #10;
    end

    initial begin
        $dumpfile("outputwave.vcd");
        $dumpvars(0,TB);
    end

endmodule