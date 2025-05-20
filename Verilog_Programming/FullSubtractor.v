// Difference = A ^ B ^ Bin
// Bout = ~ABin + ~AB + BBin

module FullSub (
    input wire a,b,bin,
    output wire diff,bo
);

    assign diff = a^b^bin;
    assign bo = (~a&b)| (~a&bin) | (b&bin);
    
endmodule

module TB;

    reg a,b,bin;
    wire d,bo;

    FullSub uut (.a(a),.b(b),.bin(bin),.diff(d),.bo(bo));

    initial begin
        a=0;b=0;bin=0;#10;
        a=0;b=0;bin=1;#10;
        a=0;b=1;bin=0;#10;
        a=0;b=1;bin=1;#10;
        a=1;b=0;bin=0;#10;
        a=1;b=0;bin=1;#10;
        a=1;b=1;bin=0;#10;
        a=1;b=1;bin=1;#10;
    end

    initial begin
        $dumpfile("output.vcd");
        $dumpvars(0,TB);
    end
    
endmodule