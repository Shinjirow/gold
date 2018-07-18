using PyPlot

for i in 1:10000
    x,y = parse.(split(readline(), ","))
end

# println(x, y)

plot(x,y)

xlim(-1e6, 1e6)
ylim(-1e6, 1e6)
grid()
axes()[:set_aspect]("equal")

savefig("test.png")
